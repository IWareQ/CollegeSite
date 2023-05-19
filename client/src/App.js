import React from 'react';
import './styles/App.css';
import './styles/button.css';
import {ReactComponent as Man} from './Man.svg';
import Typewriter from './components/Typewriter';
import './styles/typewriter.css';




function App() {
	return (
		<div>
			<div className="container">
				<header className="header">
					<div className="logo">Колледж <span className="logo-msg2"><br/>Связи</span></div>

					<nav className="links">
						<a className="links" href="#">О колледже</a>
						<a className="links" href="#">Абитуриентам</a>
						<a className="links" href="#">Студентам</a>
					</nav>
					<div className="phone-site">
						<a className="phone-site" href="tel:+7 (846) 932 25 35">+7 (846) 932 25 35</a>
					</div>
					<a href="#" className="login-button">
						<b>Вход</b>
					</a>
				</header>
			</div>
			<div className="college-msg">
				<div className="text-wrapper">
					<Typewriter/>
				<div className="msg1">Колледж, <br/></div>
				<div className="msg2"><span id="typewriter"></span><span id="cursor">|</span></div>
				<a href="" className="enroll-button">Поступить</a>
				</div>
					<div className="image">
						<Man/>
					</div>
			</div>


		</div>
	);
}

export default App;