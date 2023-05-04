import axios from 'axios';

const EXAMPLE_API_BASE_URL = 'http://localhost:8080/api/v1/example';

class ExampleService {

	getExample() {
		return axios.get(EXAMPLE_API_BASE_URL);
	}
}

export default new ExampleService()