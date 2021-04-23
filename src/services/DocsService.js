import axios from 'axios'

const DOCS_REST_API_URL = '/api/docs/list';



class DocsService {

    getDocs(){
        return  axios.get(DOCS_REST_API_URL);
       }


}

export default new DocsService();