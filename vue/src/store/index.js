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
          name: "Cora",
          breed: "Alpaca",
          color: "Black",
          age: "0",
          isAvailable: false,
          description: "a rescued alpaca",
          weight: "150",
          zip: 45371,
          city: "Tipp City",
          state: "Ohio"
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
          state: "Ohio"
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
