<template>
	<v-container fill-height>
        <v-row justify="center" align="center">
            <v-col cols="12" lg="4" sm="6">
              <div id="app">
    <vue-dropzone
      ref="myVueDropzone"
      id="dropzone"
      :options="dropzoneOptions"
      :useCustomSlot="true"
    >
      <div class="dropzone-custom-content">
        <h3 class="dropzone-custom-title">Drag and drop to upload content!</h3>
        <div class="subtitle">
          ...or click to select a file from your computer
        </div>
      </div>
    </vue-dropzone>
    <v-btn @click="fileDownload">파일다운로드</v-btn>

      <Vuetify-textbox :options="inputOptions" :value="formData.inputValue"></Vuetify-textbox>
      <Vuetify-selectsCommon :options="selectOption" :Cond="selectCond"></Vuetify-selectsCommon>
  </div>
            </v-col>
        </v-row>
	</v-container>
</template>

<script>
import vue2Dropzone from "vue2-dropzone";
import "vue2-dropzone/dist/vue2Dropzone.min.css";


export default {
    name: "App",
    components: {
    vueDropzone: vue2Dropzone
  },
  data: function() {
    return {
      dropzoneOptions: {
        url: "/upload",
        thumbnailWidth: 300,
        maxFilesize: 0.5,
        headers: { "My-Awesome-Header": "header value" },
        init: function() {
            this.on("success", function(files, response) {
                console.log(files);
                console.log(response);
            })
        }
      },
      inputOptions :{ label:'라벨', value:"123456", icon:"home",color:"#f45525" }
      ,selectOption : {label:'콤보박스',value:1}
      ,formData : {
        inputValue:"테스트당" 
      },
      selectCond:{main_code:"A001",hide:false}
    };
  },
 methods:{
    fileDownload(){

      let filename = "b55626b6-c79a-4f09-b62d-0239672c5fb0.zip";
      let arrFile = filename.split('.');
      const url = window.URL.createObjectURL(new Blob(["/download/" + filename]))
      const link = document.createElement('a')
      link.href = url
      link.setAttribute('download', 'file.' + arrFile[1]) //or any other extension
      document.body.appendChild(link)
      link.click()

        //this.$router.push("/download/6b151d06-e9e2-4ad8-8fdd-f6097528709b.png");
    }
  }
}
</script>