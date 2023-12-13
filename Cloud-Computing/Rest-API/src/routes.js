const Joi = require('joi');
const { addSymptom } = require('./handler');

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
];

module.exports = routes;
