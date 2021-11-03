import axios from "axios";
import { useDispatch, useSelector } from "react-redux";
import { useHistory } from "react-router";
import { setManager } from "../redux/actions/managerActions";

function CreateTeam(){
    let team = {}
    const manager = useSelector((state)=> state.manager.manager)
  const history = useHistory();
  const dispatch = useDispatch();

  const handleSubmit = (event)=>{
      event.preventDefault()
      axios.post(`http://localhost:9092/team/create`,team)
      .then((res)=>{
          axios.get(`http://localhost:9092/manager/${manager.managerId}/set-team/${res.data.teamId}`)
          .then((response)=>{
              axios.get(`http://localhost:9092/manager/${manager.managerId}`)
              .then((respMan)=>{
                dispatch( setManager(respMan.data) )
              })
          })
          .catch((error)=>{
              console.log(error)
          })
          history.push("/manager/detail")
      })
  }

  const handleChange = (e) => {
    team[e.target.name] = e.target.value
  }


  return(
    <div className="container mt-4">
    <div className="col justify-content-center">
      <div className="card">
        <h1 className="card-header"> Create team </h1>
        <div className="card-body">
          <form>
            <div className="form-group">
              <label htmlFor="teamName">Team Name</label>
              <input
                type="text"
                className="form-control"
                id="teamName"
                name="teamName"
                placeholder="Enter Team Name"
                onChange={handleChange}
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

export default CreateTeam;