require("dotenv").config();
let connect_redis = {
  host: process.env.REDIS_HOSTNAME,
  port: process.env.REDIS_PORT,
  password: process.env.REDIS_PASSWORD,
};
const express = require("express");
const app = express();
const path = require("path");
const hbs_engine = require("express-handlebars");
const redis = require("redis");
const bodyParser = require("body-parser");
const mongoose = require("mongoose");
const buttonModel = require("./model/buttonModel");
mongoose.connect("mongodb://127.0.0.1:27017/PickPitch").then(() => {
  console.log("connected to database");
});

app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());
const hbs = hbs_engine.create({
  extname: "hbs",
  defaultLayout: "main",
  layoutsDir: __dirname + "/views/layouts",
  partialsDir: __dirname + "/views/partials",
  helpers: {
    list: function (context, options) {
      //return "<h2>"+ context.Name +"</h1>"
      let a = "";
      for (let i = 0, j = context.length; i < j; i++) {
        a = a + options.fn(context[i]);
      }

      return a;
    },
    ifCond: function (v1, operator, v2, options) {
      switch (operator) {
        case "==":
          return v1 == v2 ? options.fn(this) : options.inverse(this);
        case "===":
          return v1 === v2 ? options.fn(this) : options.inverse(this);
        case "!=":
          return v1 != v2 ? options.fn(this) : options.inverse(this);
        case "!==":
          return v1 !== v2 ? options.fn(this) : options.inverse(this);
        case "<":
          return v1 < v2 ? options.fn(this) : options.inverse(this);
        case "<=":
          return v1 <= v2 ? options.fn(this) : options.inverse(this);
        case ">":
          return v1 > v2 ? options.fn(this) : options.inverse(this);
        case ">=":
          return v1 >= v2 ? options.fn(this) : options.inverse(this);
        case "&&":
          return v1 && v2 ? options.fn(this) : options.inverse(this);
        case "||":
          return v1 || v2 ? options.fn(this) : options.inverse(this);
        default:
          return options.inverse(this);
      }
    },
  },
});

app.engine("hbs", hbs.engine);
app.set("views", path.join(__dirname, "views"));
app.set("view engine", "hbs");

app.get("/", async (req, res) => {
  res.render("single.hbs");
});

app.get("/getStateButton", async (req, res) => {
  const allofButton = await buttonModel.find({});
  return res.status(200).json({
    state: allofButton,
  });
});

app.post("/", (req, res) => {
  console.log(req.body.hello);
});

app.get("/booking", async (req, res) => {
  const button = new buttonModel({
    state: true,
  });
  await button.save();
  return res.render("booking.hbs");
});

app.get("/payment", async (req, res) => {
  let pub, sub;

  pub = redis.createClient();
  sub = redis.createClient();
  i = 0;
  try {
    await pub.connect(connect_redis);
    await sub.connect(connect_redis);

    await pub.configSet("notify-keyspace-events", "Ex");
    await pub.setEx("6432870df3c0a5feb767b0c9", 5, "hello");

    let channel = await sub.PUBSUB_CHANNELS("__keyevent@0__:expired");

    if (channel[0] != "__keyevent@0__:expired") {
      console.log("hello");
      sub.subscribe("__keyevent@0__:expired", async (message, channel) => {
        console.log(i++);
        const allofButton = await buttonModel.find({});
        allofButton.forEach(async (button) => {
          console.log(button);
          await button.updateOne({
            state: false,
          });
        });
        //res.status(200).json(responseData);
      });
    }
    res.render("payment.hbs");
  } catch (err) {}
});

// app.get("/booking", bookingController.getBooking);
// app.get("/startBooking", bookingController.startBooking);

app.listen(3000, () => {
  console.log(`listened to ${3000}`);
});
