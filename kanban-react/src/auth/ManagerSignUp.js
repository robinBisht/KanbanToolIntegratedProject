import axios from "axios";
import { useDispatch } from "react-redux";
import { useHistory } from "react-router";
import { setManager, signupManager } from "../redux/actions/managerActions";

function ManagerSignUp(){
  const history = useHistory();
  const dispatch = useDispatch();

  let managerData = {}
  const handleChange = (e) => {
    managerData[e.target.name] = e.target.value
  }
  const handleSubmit = (event)=>{
    event.preventDefault()
    axios.post(`http://localhost:9092/manager/create`,managerData)
              .then(res =>{
                  dispatch( setManager(res.data) )
                  history.push('/manager/detail')
              })
              .catch((error)=>{
                alert("The email already exists")
                console.log(error)
              })

  }

  return (
    <div className="container mt-4">
      <div className="col justify-content-center">
        <div className="card">
          <h1 className="card-header"> Manager Sign Up </h1>
          <div className="card-body">
            <form>
              <div className="form-group">
                <label htmlFor="name">Name</label>
                <input
                  type="text"
                  className="form-control"
                  id="name"
                  name="name"
                  placeholder="Enter manager name"
                  onChange={handleChange}
                />
              </div>
              <div className="form-group">
                <label htmlFor="gender">Gender</label>
                <input
                  type="text"
                  className="form-control"
                  id="gender"
                  name="gender"
                  placeholder="Enter Gender"
                  onChange={handleChange}
                />
              </div>
              <div className="form-group">
                <label htmlFor="department">Department</label>
                <input
                  type="text"
                  className="form-control"
                  id="department"
                  name="department"
                  placeholder="Enter Department"
                  onChange={handleChange}
                />
              </div>
              <div className="form-group">
                <label htmlFor="email">Email</label>
                <input
                  type="email"
                  className="form-control"
                  id="email"
                  name="email"
                  placeholder="Enter Email"
                  onChange={handleChange}
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
                  onChange={handleChange}
                />
              </div>
              <button type="submit" className="btn btn-primary" onClick={handleSubmit}>
                Submit
              </button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
}

export default ManagerSignUp