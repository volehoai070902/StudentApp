const mongoose = require("mongoose");
const Schema = mongoose.Schema;

const buttonSchema = new Schema({
    state:{
        type:Boolean
    }
},{collection: "Button"});

const buttonModel = mongoose.model("Button",buttonSchema);

module.exports = buttonModel;