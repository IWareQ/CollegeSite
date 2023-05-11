import React from 'react';
import './styles/App.css';
import './styles/button.css';

function App() {
	return (
		<div>
			<div className="container">
				<header className="header">
					<div className="logo">CollegeSite</div>
					<nav className="links">
						<a href="#">Главная</a>
						<a href="#">О колледже</a>
						<a href="#">Абитуриентам</a>
						<a href="#">Студентам</a>
					</nav>
					<a href="#" className="shine-button">
						<b>Вход</b>
					</a>
				</header>
			</div>
		</div>
	);
}

export default App;
