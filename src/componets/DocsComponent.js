import React from 'react';
import DocsService from "../services/DocsService";



class DocsComponent extends React.Component{


    constructor(props) {
        super(props);
        this.state = {
            docs:[]
           }
    }

    componentDidMount() {
        DocsService.getDocs().then((response) => {
            this.setState({docs: response.data})
        })
    }



    onDragEnd = (ev) => {
        let x = ev.clientX;
        let y = ev.clientY;
        let el = document.elementFromPoint(x, y);
        if (!el || el.tagName !== 'TD') {
            let index = this.state.docs.findIndex(o => Number(o.id) === Number(ev.target.id));
            let newRows = this.state.docs.slice(0, index).concat(this.state.docs.slice(index + 1));
            this.setState({
                docs: newRows,
            });
        }


    }

    componentDidUpdate(prevProps) {
        if (prevProps.update !== this.props.update) {

            DocsService.getDocs().then((response) => {
                this.setState({docs: response.data})
            })
        }
    }

    render (){



        let amountAll = 0;

        this.state.docs.forEach(
            (doc) => {amountAll += doc.amount}
        )
        return (

            <div>
                <h1 className = "text-center">Docs List</h1>
                <table className= "table table-bordered">
                <thead>
                    <tr>
                        <td> DocType </td>
                        <td> CompanyID </td>
                        <td> Date </td>
                        <td> DocID </td>
                        <td> Sign </td>
                        <td> Amount </td>
                    </tr>
                </thead>
                <tbody>
                {
                    this.state.docs.map(
                        (doc) =>
                            <tr draggable={true} id ={doc.id} key ={doc.id}
                                onDragEnd={(ev) => this.onDragEnd(ev)}
                            >
                                <td> {doc.docType} </td>
                                <td> {doc.companyID} </td>
                                <td> {doc.date} </td>
                                <td> {doc.docId} </td>
                                <td> {doc.sign} </td>
                                <td> {doc.amount} </td>
                            </tr>
                    )

                }
                </tbody>
                <tfoot>
                    <tr>
                        <td> Total </td>
                        <td> </td>
                        <td> </td>
                        <td> </td>
                        <td>  </td>
                        <td> {amountAll} </td>
                    </tr>
                </tfoot>
                </table>
            </div>
        );
    }
}

export  default DocsComponent