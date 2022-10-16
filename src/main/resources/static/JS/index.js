
cards= document.createElement('template');
cards.innerHTML=`
<div id="grid">
    <div id="boxs">
        <ul id-"list">

        </ul>
    </div>
</div>
`


class Cards extends HTMLElement{
    
    constructor(){
        super();
        this.attachShadow({mode:"open"})
        this.shadowRoot.appendChild(cards.content.cloneNode(true))
        
        // List = this.shadowRoot.getElementById("list")
        
    }
    
    
    
}

window.customElements.define('my-cards', Cards);