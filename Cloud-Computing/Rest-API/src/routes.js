const Joi = require('joi');
const { addSymptom, getAllSymptom } = require('./handler');

const routes = [
  {
    method: 'POST',
    path: '/diagnose',
    handler: addSymptom,
    options: {
      validate: {
        payload: Joi.object({
          symptomDesc: Joi.string().required(),
        }),
      },
    },
  },
  {
    method: 'GET',
    path: '/symptoms',
    handler: getAllSymptom,
  },
];

module.exports = routes;
