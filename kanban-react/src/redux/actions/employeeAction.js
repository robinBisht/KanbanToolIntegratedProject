import { ActionTypes } from "../constants/action-types";

export const signupEmployee = (data) => {
    return {
        type: ActionTypes.SIGNUP,
        payload:data
    }
}
export const setEmployee = (data) => {
    return {
        type: ActionTypes.SET_EMPLOYEE,
        payload:data
    }
}

export const loginEmployee = (data) => {
  return {
    type: ActionTypes.LOGIN,
    payload: data
  };
};

export const logoutEmployee = () => {
  return {
    type: ActionTypes.LOGOUT
  };
};