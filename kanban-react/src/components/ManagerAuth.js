import { Link } from "react-router-dom";

function ManagerAuth(){
    return <div className="card" style={{width: "30rem"}}>
    <h5 className="card-header">Manager Authenticaion Card</h5>
    <div className="card-body">
      <h5 className="card-title">Sign Up to create a new Manager</h5>
      <Link to="/manager/signup"> <button className="btn btn-primary">Manager Sign Up</button>  </Link>
      <h5 className="card-title">Login</h5>
      <p className="card-text">
        Already Have an account? Then Log In
      </p>
      <Link to="/manager/login"> <button className="btn btn-primary">Manager Login</button>  </Link>
    </div>
  </div>;
}

export default ManagerAuth;