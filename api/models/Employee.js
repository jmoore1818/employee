/**
 * Employee.js
 *
 * @description :: TODO: You might write a short summary of how this model works and what it represents here.
 * @docs        :: http://sailsjs.org/documentation/concepts/models-and-orm/models
 */
var md5 = require('MD5');
module.exports = {
  attributes: {
  	schema: true,
  	firstName: {
	    type: 'string',
	    required: true,
	    minLength: 2
  	},
  	lastName: {
	    type: 'string',
	    required: true,
	    minLength: 2
  	},
  	email: {
	    type: 'string',
	    unique: true,
	    required: true,
	    email: true
  	},
  	homePhone: {
  		type: 'string',
  		regex: /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/
  	},
  	cellPhone: {
  		type: 'string',
  		regex: /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/
  	},
  	password: {
  		type: "string",
  		required: true,
  		regex: /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,}$/
  	},
  	active: {
	    type: 'int',
	    enum: [1,0],
	    required: true
  	}
  },
  afterValidate: function(employee, cb) {
	employee.password = md5(employee.password);
	cb();
  }
};

