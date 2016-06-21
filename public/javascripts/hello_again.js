ReactDOM.render(
    <h1>Projects page</h1>,
    document.getElementById('example')
);

var CommentBox = React.createClass({displayName: 'CommentBox',
    render: function() {
        return (
            React.createElement('div', {className: "commentBox"},
                "Welcome to my project page."
            )
        );
    }
});

ReactDOM.render(
    React.createElement(CommentBox, null),
    document.getElementById('content')
);

