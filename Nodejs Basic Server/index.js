const express = require("express");

const sequelize = require("./config/database");
const router = require("./controller/UserController");

const app = express();

sequelize
  .sync({})
  .then(() => console.log("Database connected successfully"))
  .catch((err) => {
    console.log(err);
  });

app.use(express.json());
app.use(router);

const port = 4401;

app.listen(port, function () {
  console.log("server started");
});
