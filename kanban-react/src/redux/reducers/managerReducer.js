import { ActionTypes } from "../constants/action-types";
const initialState = {
  manager: {},
};

export const managerReducer = (state = initialState, action) => {
  switch (action.type) {
    case ActionTypes.SIGNUP:
      return {
        ...state,
        manager: action.payload,
      };
    case ActionTypes.LOGIN:
      return {
        ...state,
        manager: action.payload,
      };
    case ActionTypes.SET_MANAGER:
      return {
        ...state,
        manager: action.payload,
      };
    case ActionTypes.LOGOUT:
      return {
        ...state,
        manager: {},
      };
    default:
      return state;
  }
};
