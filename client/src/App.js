import './css/App.css';
import React, {Component} from 'react';
import ExampleService from './services/ExampleService';

class App extends Component {

	constructor(props) {
		super(props)

		this.state = {
			example: []
		}
	}

	componentDidMount() {
		ExampleService.getExample().then(res => {
			this.setState({example: res.data});
		});
	}

	render() {
		return (
			<div className="App">
				<header className="App-header">
					<h2>{this.state.example}</h2>
				</header>
			</div>
		)
	}
}

export default App;
