import EmployeeAuth from '../components/EmployeeAuth';
import ManagerAuth from '../components/ManagerAuth';
function HomePage(){
    return (
        <div className="mt-4">
            <div className="text-center">
                <h1 className="display-3"> Kanban Tool </h1>
            </div>
            
            <div className="d-flex justify-content-center">
            <ManagerAuth/>
            <EmployeeAuth/>
            </div>
        </div>
    )
}
export default HomePage;