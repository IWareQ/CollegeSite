import '../styles/App.css';
import {Component} from 'react';
import ExampleService from '../services/ExampleService';

class App extends Component {

	constructor(props) {
		super(props)

		this.state = {
			example: 'Загрузка...'
		}
	}

	componentDidMount() {
		ExampleService.getExample().then(res => {
			this.setState({example: res.data});
		}).catch(() => {
			this.setState({example: 'Сервер не включен'});
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
