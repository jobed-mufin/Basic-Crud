const User = require("../model/User");

// create user
async function createUser(payload) {
  return await User.create({ ...payload });
}

// get all user

async function getAllUsers() {
  return await User.findAll();
}

// get user by id
async function getUserByID(id) {
  return await User.findByPk(id);
}

// delete user by id
async function deleteUserByID(id) {
  const user = await this.getUserByID(id);
  if (!user) {
    return "User not found";
  }
  await user.destroy();
  return "User deleted !";
}

// update user by id
async function updateUser(id, payload) {
  const user = await this.getUserByID(id);
  if (!user) {
    return "User is not found";
  }
  return user.update({ ...payload });
}

module.exports = {
  createUser,
  getAllUsers,
  getUserByID,
  deleteUserByID,
  updateUser,
};
