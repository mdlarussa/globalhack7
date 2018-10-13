'use strict';

// tag::vars[]
const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');
// end::vars[]

// tag::app[]
class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {immigrants: []};
	}

	componentDidMount() {
		client({method: 'GET', path: '/api/immigrants'}).done(response => {
			this.setState({immigrants: response.entity._embedded.immigrants});
		});
	}

	render() {
		return (
			<ImmigrantList immigrants={this.state.immigrants}/>
		)
	}
}
// end::app[]

// tag::immigrant-list[]
class ImmigrantList extends React.Component{
	render() {
		const immigrants = this.props.immigrants.map(immigrant =>
			<Immigrant key={immigrant._links.self.href} immigrant={immigrant}/>
		);
		return (
			<table>
				<tbody>
					<tr>
						<th>Name</th>
						<th>Email</th>
					</tr>
					{immigrants}
				</tbody>
			</table>
		)
	}
}
// end::immigrant-list[]

// tag::immigrant[]
class Immigrant extends React.Component{
	render() {
		return (
			<tr>
				<td>{this.props.immigrant.name}</td>
				<td>{this.props.immigrant.email}</td>
			</tr>
		)
	}
}
// end::immigrant[]

// tag::render[]
ReactDOM.render(
	<App />,
	document.getElementById('react')
)
// end::render[]

