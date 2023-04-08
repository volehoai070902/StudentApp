const { workerData, parentPort } = require('worker_threads');

// Set a timer for 10 minutes
// const paymentTimer = setTimeout(() => {
//   parentPort.postMessage('Payment not completed in time.');
 
// }, 10 * 60 * 1000);

// Simulate payment process (replace with actual payment logic)
setTimeout(() => {
  console.log("hello");
  clearTimeout(paymentTimer);
  
  parentPort.postMessage('Payment completed.');
  
}, 5000); // Wait for 5 seconds (replace with actual payment timeout)
