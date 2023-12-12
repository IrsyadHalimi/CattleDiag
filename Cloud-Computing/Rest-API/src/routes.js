const Joi = require('joi');
const { symptomHandler } = require('./handler');

const routes = [
  {
    method: 'POST',
    path: '/diagnose',
    handler: symptomHandler,
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
