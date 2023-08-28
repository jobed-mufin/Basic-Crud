const { Sequelize } = require("sequelize");

const sequelize = new Sequelize({
  dialect: "sqlite",
  storage: "testdb.sqlite",
  logging: false,
});

module.exports = sequelize;
