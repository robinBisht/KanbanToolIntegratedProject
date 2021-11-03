import axios from "axios";
import { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { setManager } from "../redux/actions/managerActions";

function AllEmployee(){
    const manager = useSelector((state)=> state.manager.manager)
    const dispatch = useDispatch();
    const [allEmployees,setAllEmployees] = useState([])
    useEffect(()=>{
        axios.get(`http://localhost:9092/employee`)
        .then((res)=>{
            console.log("All employees")
            console.log(res.data)
            setAllEmployees(res.data)
        })
        .catch((error)=>{
            console.log(error)
        })
    },[manager])
    const handleAddToTeam = (empId)=>{
        axios.get(`http://localhost:9092/employee/${empId}/add-to-team/${manager.team.teamId}`)
        .then((res)=>{
            axios.get(`http://localhost:9092/manager/${manager.managerId}`)
            .then((response)=>{
                dispatch(setManager(response.data))
            })
            .catch((err)=>console.log(err))
        })
        .catch((error)=>{
            console.log(error)
        })
    }
    const renderTableBody = allEmployees.map((emp)=>{
        return <tr>
            <td> {emp.name} </td>
            <td> {emp.email} </td>
            <td> {emp.department} </td>
            <td>{ emp.team === null ? <button className="btn btn-primary" onClick={()=>handleAddToTeam(emp.employeeId)}> Add To Team </button> : manager.team.teamName }</td>
        </tr>
    })

    return (
        <div className="card">
            <div className="card-body">
            <table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Employee name</th>
      <th scope="col">Employee Email</th>
      <th scope="col">Employee Department</th>
      <th scope="col">Team</th>
    </tr>
  </thead>
  <tbody>
    {renderTableBody}
  </tbody>
</table>
                </div>

        </div>

    )
}

export default AllEmployee;