import { BrowserRouter,Switch,Route } from 'react-router-dom';
import './App.css';
import HomePage from './pages/HomePage';
import ManagerSignUp from './auth/ManagerSignUp';
import ManagerLogin from './auth/ManagerLogin';
import EmployeeSignUp from './auth/EmployeeSignUp';
import EmployeeLogin from './auth/EmployeeLogin';
import Header from './layouts/Header';
import ManagerDetail from './pages/ManagerDetail';
import ManagerDashboard from './pages/ManagerDashboard';
import EmployeeDetails from './pages/EmployeeDetails';
import EmployeeProfile from './pages/EmployeeProfile';
import CreateTask from './pages/CreateTask';
import CreateTeam from './pages/CreateTeam';
import AllEmployee from './pages/AllEmployee';
import TeamDetail from './pages/TeamDetail';

function App() {
  return (
    <BrowserRouter>
    <Header/>
    <Switch>
    <Route exact path="/" component={HomePage}></Route>
    <Route exact path="/manager/signup" component={ManagerSignUp}></Route>
    <Route exact path="/manager/login" component={ManagerLogin}></Route>
    <Route exact path="/manager/detail" component={ManagerDetail}></Route>
    <Route exact path="/manager/dashboard" component={ManagerDashboard}></Route>
    <Route exact path="/employee/signup" component={EmployeeSignUp}></Route>
    <Route exact path="/employee/login" component={EmployeeLogin}></Route>
    <Route exact path="/employee/detail" component={EmployeeDetails}></Route>
    <Route exact path="/employee/profile" component={EmployeeProfile}></Route>
    <Route exact path="/employee/all" component={AllEmployee}></Route>
    <Route exact path="/task/create" component={CreateTask}></Route>
    <Route exact path="/team/create" component={CreateTeam}></Route>
    <Route exact path="/team/detail" component={TeamDetail}></Route>

    
    </Switch>
    </BrowserRouter>

  );
}

export default App;
