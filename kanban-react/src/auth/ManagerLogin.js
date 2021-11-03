import axios from "axios";
import { useState } from "react";
import { useDispatch } from "react-redux";
import { useHistory } from "react-router";
import { loginManager } from "../redux/actions/managerActions";

function ManagerLogin(){
    const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const history = useHistory();
  const dispatch = useDispatch();

  const handleSubmit = (event)=>{
      event.preventDeault()
      axios.get(`http://localhost:9092/manager/login/${email}/${password}`)
      .then((res)=>{
          dispatch( loginManager(res.data) )
          history.dispatch("/manager/detail")
      })
      .catch((error)=>{
        alert("error has occurred")
      })
  }

  const handlePasswordChange = (e) => {
    setPassword(e.target.value)
  }
  const handleEmailChange = (e) => {
    setEmail(e.target.value)
  }

  return (
    <div className="container mt-4">
    <div className="col justify-content-center">
      <div className="card">
        <h1 className="card-header"> Login </h1>
        <div className="card-body">
          <form>
            <div className="form-group">
              <label htmlFor="email">Email</label>
              <input
                type="text"
                className="form-control"
                id="email"
                name="email"
                placeholder="Enter email"
                onChange={handleEmailChange}
              />
            </div>
            <div className="form-group">
              <label htmlFor="password">Password</label>
              <input
                type="password"
                className="form-control"
                id="password"
                name="password"
                placeholder="Password"
                onChange={handlePasswordChange}
              />
            </div>
            <button
              type="submit"
              className="btn btn-primary"
              onClick={handleSubmit}
            >
              Submit
            </button>
          </form>
        </div>
      </div>
    </div>
  </div>
  )
}

export default ManagerLogin;