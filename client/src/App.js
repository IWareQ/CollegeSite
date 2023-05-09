import React from 'react';
import logo from './logo.svg';
import './styles/App.css';

function App(){

    return(
        <div className="container">
            <div className="header">
            <div className="logo">Logo</div>
            <div className="links">
                <a href="#">Главная</a>
                <a href="#">О колледже</a>
                <a href="#">Абитуриентам</a>
                <a href="#">Студентам</a>
            </div>
            </div>
        </div>
    );
}

export default App;
