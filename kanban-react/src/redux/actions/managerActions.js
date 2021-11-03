import { ActionTypes } from "../constants/action-types";

export const signupManager = (data) => {
    return {
        type: ActionTypes.SIGNUP,
        payload:data
    }
}
export const setManager = (data) => {
    return {
        type: ActionTypes.SET_MANAGER,
        payload:data
    }
}

export const loginManager = (data) => {
  return {
    type: ActionTypes.LOGIN,
    payload: data
  };
};

export const logoutManager = () => {
  return {
    type: ActionTypes.LOGOUT
  };
};