const express = require("express");

const userService = require("../services/userService");

const router = express.Router();

router.post("/create-user", async function (request, response) {
  const payload = request.body;

  const newUser = await userService.createUser(payload);

  response.status(201).json(newUser);
});

router.get("/get-all-users", async function (request, response) {
  const allUsers = await userService.getAllUsers();

  response.status(200).json(allUsers);
});

router.get("/get-user-by-id/:id", async function (request, response) {
  const id = request.params.id;
  const user = await userService.getUserByID(id);

  response.status(200).json(user);
});

router.delete("/delete-user-by-id/:id", async function (request, response) {
  const id = request.params.id;

  const res = await userService.deleteUserByID(id);
  response.status(202).json({ message: res });
});

router.patch("/update-user-by-id/:id", async function (request, response) {
  const id = request.params.id;
  const payload = request.body;

  const updatedUser = await userService.updateUser(id, payload);
  response.status(202).json(updatedUser);
});

module.exports = router;
