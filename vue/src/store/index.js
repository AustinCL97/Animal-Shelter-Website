import { createStore as _createStore } from 'vuex';
import axios from 'axios';

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      token: currentToken || '',
      user: currentUser || {},

      pets: [
        {
          id: 1,
          name: "YiaYia",
          breed: "Alpaca",
          color: "White/Beige",
          age: "8",
          isAvailable: false,
          description: "A spirited and spunky alpaca rescued from a breeder",
          weight: "106",
          zip: 45371,
          city: "Tipp City",
          state: "Ohio",
          img: "src/images/yiayia.jpg"
        },
        {
          id: 2,
          name: "Sampson",
          breed: "German Shorthaired Pointer",
          color: "Liver Tick",
          age: "8",
          isAvailable: false,
          description: "an opinionated GSP",
          weight: "90",
          zip: 45309,
          city: "Brookville",
          state: "Ohio",
          img: "src/images/sampson.jpg"
        }
      ]
    },
    mutations: {
      SET_AUTH_TOKEN(state, token) {
        state.token = token;
        localStorage.setItem('token', token);
        axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
      },
      SET_USER(state, user) {
        state.user = user;
        localStorage.setItem('user', JSON.stringify(user));
      },
      LOGOUT(state) {
        localStorage.removeItem('token');
        localStorage.removeItem('user');
        state.token = '';
        state.user = {};
        axios.defaults.headers.common = {};
      }
    },
  });
  return store;
}
