import { Link } from "react-router-dom";

function EmployeeAuth() {
  return <div className="card" style={{width: "30rem"}}>
    <h5 className="card-header">Employee Authenticaion Card</h5>
    <div className="card-body">
      <h5 className="card-title">Sign Up to create a new Employee</h5>
      <Link to="/employee/signup"> <button className="btn btn-primary">Employee Sign Up</button>  </Link>
      <h5 className="card-title">Login</h5>
      <p className="card-text">
        Already Have an account? Then Log In
      </p>
      <Link to="/employee/login"> <button className="btn btn-primary">Employee Login</button>  </Link>
    </div>
  </div>;
}

export default EmployeeAuth;
