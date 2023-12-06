/* eslint-disable linebreak-style */
const Joi = require('joi');
const { addSymptomHandler } = require('./handler');

const routes = [
  {
    method: 'POST',
    path: '/symptom',
    handler: addSymptomHandler,
    options: {
      validate: {
        payload: Joi.object({
          cattle: Joi.string().required(),
          desc: Joi.string().required(),
        }),
      },
    },
  },
];

module.exports = routes;
