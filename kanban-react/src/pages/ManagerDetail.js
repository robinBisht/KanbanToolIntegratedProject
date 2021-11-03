import { useEffect } from "react";
import { useSelector } from "react-redux";
import { useHistory } from "react-router";
import { Link } from "react-router-dom";

function ManagerDetails(){
    const manager = useSelector((state)=> state.manager.manager)
    const employee = useSelector((state)=> state.employee.employee)
    const history = useHistory();

    useEffect(()=>{
      if( Object.keys(manager) === 0 ){
        history.push("/")
      }
    },[]);
    return (
        <div className="container">
      <h1 className="display-2"> MANAGER PAGE </h1>
      <div className="card">
        <div className="jumbotron">
          <h1 className="display-4">Hello, {manager.name} </h1>
          <p className="lead">
            This is a your Personal Page and here you can do tasks like adding a team or checking employees.
          </p>
          <hr className="my-4" />
          <p className="lead">
            Below Link will take you to page where you can add a team.
          </p>
          <p className="lead">
            <Link to="/team/create">
            <button className="btn btn-secondary btn-lg">
                Add Team
            </button>
            </Link>
            </p>
            <hr className="my-4" />
          <p className="lead">
            Below Link will take you to page where you can view employee of your department
          </p>
          <p className="lead">
            <Link to="/employee/all">
            <button className="btn btn-info btn-lg">
                View All Employees
            </button>
            </Link>
            </p>
            <hr className="my-4" />
            <p className="lead">
            Below Link will take you to page where you can add task
          </p>
          <p className="lead">
            <Link to="/task/create">
            <button className="btn btn-primary btn-lg">
                Create Task
            </button>
            </Link>
            </p>
    </div>
    <p className="lead"> Below is your data </p>
    <table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Email</th>
      <th scope="col">Department</th>
      <th scope="col">Team name</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>{manager.name}</td>
      <td>{manager.email}</td>
      <td>{manager.department}</td>
      {manager.team !== null &&  <td> {manager.team.teamName} </td> }
    </tr>
  </tbody>
</table>
</div>


</div>
    )
}
export default ManagerDetails