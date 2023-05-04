import React, {Component} from 'react'
import ExampleService from '../services/ExampleService'

class ExampleComponent extends Component {

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
			<div>
				<h2>{this.state.example}</h2>
			</div>
		)
	}
}

export default ExampleComponent
