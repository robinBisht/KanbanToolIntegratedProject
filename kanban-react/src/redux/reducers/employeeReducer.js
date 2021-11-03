import { ActionTypes } from "../constants/action-types";
const initialState = {
  employee: {},
};

export const employeeReducer = (state = initialState, action) => {
  switch (action.type) {
    case ActionTypes.SIGNUP:
      return {
        ...state,
        employee: action.payload,
      };
    case ActionTypes.LOGIN:
      return {
        ...state,
        employee: action.payload,
      };
    case ActionTypes.SET_EMPLOYEE:
      return {
        ...state,
        employee: action.payload,
      };
    case ActionTypes.LOGOUT:
      return {
        ...state,
        employee: {},
      };
    default:
      return state;
  }
};
