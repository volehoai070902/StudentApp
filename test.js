// const cron = require('node-cron');

// // Định nghĩa công việc thanh toán của một người dùng
// function paymentJob(userId) {
//   console.log(`User ${userId} payment is due!`);
// }

// // Lên lịch đặt thời gian thanh toán cho người dùng
// function schedulePayment(userId) {
//   let payment = true;
//   const paymentTime = "5 * * * * *" // Thời điểm thanh toán sau 10 phút
//   console.log(`Scheduling payment for user ${userId} at ${paymentTime}`);

//   cron.schedule(paymentTime, () => {
//     paymentJob(userId);
//     if (payment){
//       return;
//     }
//     else{
//       return;
//     }
//   });
// }

// // Sử dụng công việc lên lịch cho từng người dùng
// schedulePayment('user1');
// schedulePayment('user2');
// schedulePayment('user3');

// const  CronJob = require("cron").CronJob;
// const payment = new CronJob("*/5 * * * * *",()=>{
//     console.log("hello");
// })

// payment.addCallback(()=>{
//     console.log("hello 1");
// })

// payment.addCallback(()=>{
//     console.log("hello 2");
// })

// payment.start();


  
// const { Worker } = require('worker_threads');

// function handleBookingRequest(user) {
//   const worker = new Worker('./bookGroundWorker.js', { workerData: user });

//   worker.on('message', (message) => {
//     console.log(`User ${user.id}: ${message}`);
//   });

//   worker.on('error', (error) => {
//     console.error(`User ${user.id}: ${error}`);
//   });

//   worker.on('exit', (code) => {
//     if (code !== 0) {
//       console.error(`User ${user.id}: Worker stopped with exit code ${code}`);
//     }
//   });
// }

// // Example usage
// const users = [
//   { id: 1, name: 'User 1' },
//   { id: 2, name: 'User 2' },
//   { id: 3, name: 'User 3' },
// ];


// handleBookingRequest(users[0]);
// handleBookingRequest(users[1]);
// handleBookingRequest(users[2]);


const redis = require("redis");
const  REDIS_PORT = 6379;
const subscribe = redis.createClient(REDIS_PORT);
const express = require("express");
const app = express();
let sub;

sub=redis.createClient();

sub.connect();

sub.subscribe("__keyevent@0__:expired", async(message,key) => {
    console.log("key=>", message);
    
})

app.listen(3010,()=>{
  console.log("listen to 3010")
})

