
const { Worker } = require('worker_threads');
let workerPromise = [];
let count = 0;
const booking = {
  getBooking: async (req, res) => {
    let payment = false;

    try {
    
      console.log(await addDelay({
        orderID:"123",
        delay:5
      }));
      
    } catch (err) {
      // console.log("trời ơi là trời");
      // node_cron.schedule("*/5 * * * * *", () => {
      //   if (payment) {
      //     return res.status(200).json({
      //       confirmed: "da thanh toan",
      //       state_btn: true,
      //     });
      //   } else {
      //     return res.status(200).json({
      //       confirmed: "chua thanh toan",
      //       state_btn: false,
      //     });
      //   }
      // }).start();
      // let i = 0;
      // const intervalID = setInterval(() => {
      //   console.log(i);
      //   i++;
      //   if (payment) {
      //     clearInterval(intervalID);
      //     clearTimeout(paymentTime);
      //     return res.status(200).json({ confirmed: "đã thanh toán",state_btn:true });
      //   }
      // }, 1000*1);
      // const paymentTime= setTimeout(() => {
      //   clearInterval(intervalID);
      //   if (payment) {
      //     console.log("tốt lắm");
      //   } else {
      //     return res.status(200).json({ confirmed: "chưa thanh toán",state_btn:false });
      //   }
      // }, 1000*5);
    }
  },

  startBooking: async (req, res) => {
    const results = await Promise.all(workerPromise);
    console.log(results);
  },
};

module.exports = booking;
