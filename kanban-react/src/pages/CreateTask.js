import axios from "axios";
import { useState } from "react";
import ReactDatePicker from "react-datepicker";
import { useDispatch, useSelector } from "react-redux";
import { useHistory } from "react-router";
import { setManager } from "../redux/actions/managerActions";

function CreateTask(){
    let task = {}
    const manager = useSelector((state)=> state.manager.manager)
    const history = useHistory();
    const dispatch = useDispatch();
  
    const handleSubmit = (event)=>{
        event.preventDefault()
        axios.post(`http://localhost:9092/task/create`,task)
        .then((res)=>{
            axios.get(`http://localhost:9092/team/${manager.team.teamId}/add-task/${res.data.taskid}`)
            .then((response)=>{
                axios.get(`http://localhost:9092/manager/${manager.managerId}/set-team/${response.data}`)
                .then((responseTask)=>{
                    axios.get(`http://localhost:9092/manager/${manager.managerId}`)
                    .then((respMan)=>{
                      dispatch( setManager(respMan.data) )
                    })
                })
            })
            .catch((error)=>{
                console.log(error)
            })
            history.push("/manager/detail")
        })
    }
  
    const handleChange = (e) => {
      task[e.target.name] = e.target.value
    }
  
  
    return(
      <div className="container mt-4">
      <div className="col justify-content-center">
        <div className="card">
          <h1 className="card-header"> Create Task </h1>
          <div className="card-body">
            <form>
              <div className="form-group">
                <label htmlFor="taskName">Task Name</label>
                <input
                  type="text"
                  className="form-control"
                  id="taskName"
                  name="taskName"
                  placeholder="Enter Task Name"
                  onChange={handleChange}
                />
              </div>
              <label>Choose Project Start Date </label>
              <input type="datetime-local" name="taskAssignedDate" onSelect={handleChange}/>
              <label>Choose Project End Date </label>
              <input type="datetime-local" name="taskSubmissionDate" onSelect={handleChange}/>
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

export default CreateTask;