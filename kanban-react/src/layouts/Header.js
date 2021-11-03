import { useDispatch, useSelector } from "react-redux";
import { useHistory } from "react-router";
import { Link } from "react-router-dom";
import { logoutEmployee } from "../redux/actions/employeeAction";
import { logoutManager } from "../redux/actions/managerActions";

function Header(){
    const manager = useSelector((state) => state.manager.manager);
    const employee = useSelector((state) => state.employee.employee);
    
    const dispatch = useDispatch();
    const history = useHistory();
    const handleLogOut = ()=>{
      dispatch( logoutEmployee() )
      dispatch( logoutManager() )
      history.push('/')
    }
    return (
        <nav className="navbar navbar-expand-lg sticky-top navbar-dark bg-dark justify-content-between">
        <Link to="/"><span className="navbar-brand">Kanban</span></Link>
        <div className="navbar-nav navbar-right">
        <ul className="nav navbar-nav">
            { Object.keys(manager).length !== 0 && <li><Link to="/manager/detail"> <span className="nav-link"> {manager.email} </span> </Link></li>  }
            { Object.keys(employee).length !== 0 && <li><Link to="/employee/detail"> <span className="nav-link"> {employee.email} </span> </Link></li>  }
            {(Object.keys(manager).length!==0 || Object.keys(employee).length!==0 )  && <li onClick={handleLogOut} > <span className="nav-link">Log Out</span> </li> }
        </ul>
        </div>
      </nav>
    )
}

export default Header;