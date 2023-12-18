const Joi = require('joi');
const { addSymptom, getAllSymptom, getAllDesease } = require('./handler');

const routes = [
  {
    method: 'POST',
    path: '/diagnose',
    handler: addSymptom,
    options: {
      validate: {
        payload: Joi.object({
          animalId: Joi.string().required(),
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
  {
    method: 'GET',
    path: '/deseases',
    handler: getAllDesease,
  },
];

module.exports = routes;
