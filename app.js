const express = require("express");
const app = express();
const path = require("path");
const hbs_engine = require("express-handlebars");
const redis = require("redis");
const bodyParser = require("body-parser");
const { channel } = require("diagnostics_channel");

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

app.get("/", (req, res) => {
  res.render("single.hbs");
});

app.post("/", (req, res) => {
  console.log(req.body.hello);
});

app.post("/photos", async (req, res) => {
  let pub, sub;
  pub = redis.createClient();
  sub = redis.createClient();
  i = 0;
  try {
    console.log("hello");
    await pub.connect();
    await sub.connect();

    await pub.configSet("notify-keyspace-events", "Ex");
    await pub.setEx(req.body.name, 5, "hello");

  
    sub.subscribe("__keyevent@0__:expired", async(message, channel) => {
      
        console.log(i++);
        res.status(200).json({
            data:"thanh cong",
            state_btn: false
        });
    });
    

  } catch (err) {   }
  res.on("finish", () => {
    console.log("hello 1");
    sub.unsubscribe("__keyevent@0__:expired");
  });
});

// app.get("/booking", bookingController.getBooking);
// app.get("/startBooking", bookingController.startBooking);

app.listen(3000, () => {
  console.log(`listened to ${3000}`);
});
