import React, { useState } from 'react';
import apiClient from '../../api/apiClient';

const Register = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [retypedPassword, setRetypedPassword] = useState('');
  const [fullName, setFullName] = useState('');
  const [phoneNumber, setPhoneNumber] = useState('');

  const [emailError, setEmailError] = useState('');
  const [passwordError, setPasswordError] = useState('');
  const [retypedPasswordError, setRetypedPasswordError] = useState('');
  const [fullNameError, setFullNameError] = useState('');
  const [phoneNumberError, setPhoneNumberError] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (password !== retypedPassword) {
      setRetypedPasswordError('Passwords do not match!');
      return;
    }

    try {
      const response = await apiClient.post('/auth/register', {
        email,
        password,
        fullName,
        phone_number: phoneNumber,
      });
      console.log(response.data);
    } catch (error) {
      console.error('Registration failed:', error);
    }
  };

  const validateEmail = (email) => {
    if (!email) {
      setEmailError('Email is required');
    } else if (!/\S+@\S+\.\S+/.test(email)) {
      setEmailError('Email is invalid');
    } else {
      setEmailError('');
    }
  };

  const validatePassword = (password) => {
    if (!password) {
      setPasswordError('Password is required');
    } else if (password.length < 6) {
      setPasswordError('Password must be at least 6 characters');
    } else {
      setPasswordError('');
    }
  };

  const validateRetypedPassword = (retypedPassword) => {
    if (retypedPassword !== password) {
      setRetypedPasswordError('Passwords do not match');
    } else {
      setRetypedPasswordError('');
    }
  };

  const validateFullName = (fullName) => {
    if (!fullName) {
      setFullNameError('Full name is required');
    } else {
      setFullNameError('');
    }
  };

  const validatePhoneNumber = (phoneNumber) => {
    if (!phoneNumber) {
      setPhoneNumberError('Phone number is required');
    } else if (!/^\d{10}$/.test(phoneNumber)) {
      setPhoneNumberError('Phone number is invalid');
    } else {
      setPhoneNumberError('');
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <div>
        <label>Email</label>
        <input
          type="email"
          value={email}
          onChange={(e) => {
            setEmail(e.target.value);
            validateEmail(e.target.value);
          }}
        />
        {emailError && <span>{emailError}</span>}
      </div>
      <div>
        <label>Password</label>
        <input
          type="password"
          value={password}
          onChange={(e) => {
            setPassword(e.target.value);
            validatePassword(e.target.value);
          }}
        />
        {passwordError && <span>{passwordError}</span>}
      </div>
      <div>
        <label>Retype Password</label>
        <input
          type="password"
          value={retypedPassword}
          onChange={(e) => {
            setRetypedPassword(e.target.value);
            validateRetypedPassword(e.target.value);
          }}
        />
        {retypedPasswordError && <span>{retypedPasswordError}</span>}
      </div>
      <div>
        <label>Full Name</label>
        <input
          type="text"
          value={fullName}
          onChange={(e) => {
            setFullName(e.target.value);
            validateFullName(e.target.value);
          }}
        />
        {fullNameError && <span>{fullNameError}</span>}
      </div>
      <div>
        <label>Phone Number</label>
        <input
          type="text"
          value={phoneNumber}
          onChange={(e) => {
            setPhoneNumber(e.target.value);
            validatePhoneNumber(e.target.value);
          }}
        />
        {phoneNumberError && <span>{phoneNumberError}</span>}
      </div>
      <button type="submit">Register</button>
    </form>
  );
};

export default Register;
