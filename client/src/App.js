import React from 'react';
import './styles/App.css';
import './styles/button.css';
import {ReactComponent as Man} from './Man.svg';

function App() {
	return (
		<div>
			<div className="container">
				<header className="header">
					<div className="logo">Колледж <span className=""><br/>Связи</span></div>

					<nav className="links">
						<a href="#">О колледже</a>
						<a href="#">Абитуриентам</a>
						<a href="#">Студентам</a>
					</nav>
					<div className="phone-site">
						<a href="tel:+7 (846) 932 25 35">+7 (846) 932 25 35</a>
					</div>
					<a href="#" className="login-button">
						<b>Вход</b>
					</a>
				</header>
			</div>
			<div className="college-msg">
				<div className="msg1">Колледж, <br/>
					<div className="msg2">где учат профессиям будущего</div>
				</div>
			</div>
			<div className="enroll">
				<a href="" className="enroll-button">Поступить</a>
			</div>
			<div className="image-man">
				<Man/>
			</div>
		</div>
	);
}

export default App;