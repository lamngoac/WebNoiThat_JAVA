<template>
<div class="h-popup" v-if="isShow">
    <popup @closePopup="closePopup" :width="600" :height="500">
        <template slot="header">
            <div class="h-titlte">
                {{ titlleMode }}
            </div>
        </template>
        <template slot="content">
            <div>
                <div class="h-row h-display-flex h-mg-t10">
                    <div class="h-col h-flex">
                        <Input :title="'Tiêu đề dự án'" placeholder="Tiêu đề dự án" v-model="project.projectTitle" />
                    </div>
                </div>
                <div class="h-row h-display-flex">
                    <div class="h-col h-flex">
                        <Textarea :title="'Nội dung dự án'" placeholder="Nội dung dự án" v-model="project.projectContent" />
                        </div>
          </div>
          <div class="h-row h-display-flex">
            <div class="h-col h-flex">
              <InputFile :title="'Ảnh dự án'" ref="inputFile" :name="project.linkImage"/>
            </div>
          </div>
        </div>
      </template>
      <template slot="footer">
        <div style="width: 100%">
          <div class="h-display-flex jus-end">
            <div class="h-button h-btn-cancel h-mr-15" @click="closePopup">
              Hủy bỏ
            </div>
            <div class="h-button h-btn-save" @click="saveProject">Lưu</div>
          </div>
        </div>
      </template>
    </popup>
  </div>
</template>

<script>
import {
    mapActions
} from "vuex";
import {
    ModuleProject
} from "@/store/module-const";
import Popup from "@/views/components/popup/Popup";
import Input from "@/views/components/input/Input";
import Textarea from "@/views/components/textarea/Textarea";
import InputFile from "@/views/components/inputFile/InputFile";
import commonFunc from '@/common/common';
export default {
    components: {
        Popup,
        Input,
        Textarea,
        InputFile,
    },
    name: "AdminProjectDetail",
    props: {
        isShow: {
            typeof: Boolean,
            default: false,
        },
        project: {
            typeof: Object,
            default: null,
        },

        mode: {
            typeof: String,
            default: "add",
        },
    },
    data() {
        return {

        };
    },
    computed: {
        titlleMode() {
            const me = this;
            if (me.mode == 0) {
                return me.$t("i18nProject.addProject");
            }
            if (me.mode == 1) {
                return me.$t("i18nProject.editProject");
            }
            return "";
        },
    },
    methods: {
        ...mapActions(ModuleProject, [
            "addProjectAsync",
            "editProjectAsync",
        ]),
        async loadData() {
            const me = this;
            await me.$emit("loadData");
        },
        async saveProject() {
            const me = this;
            if (me.$refs.inputFile.fileName) {
                me.project.linkImage = "";
            }
            me.project.linkImage = commonFunc.convertImgSaveDB(me.$refs.inputFile.fileName);
            // Thêm
            if (me.mode == "add") {
                await me.addProjectAsync(me.project);
            }
            // Sửa
            else if (me.mode == "edit") {
                await me.editProjectAsync(me.project);
            }
            me.loadData();
            me.closePopup();
        },
        closePopup() {
            const me = this;
            me.$emit("closePopup");
        },
    },
};
</script>

<style scoped>
.h-popup {}

.h-titlte {
    font-weight: bold;
    font-size: 18px;
}

.h-row {
    margin-bottom: 10px;
}
</style>
