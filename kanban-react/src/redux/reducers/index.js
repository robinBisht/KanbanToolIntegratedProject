
import { combineReducers } from "redux";
import { employeeReducer } from "./employeeReducer";
import { managerReducer } from "./managerReducer";

const reducers = combineReducers({
    employee:employeeReducer,
    manager:managerReducer
  
});
export default reducers;