<template>
  <v-container class="fill-height">
    <v-row justify="center">
      <v-col cols="auto">
        <v-card width="460">
          <v-card-text class="text-center px-12 py-6">
            <v-row class="text-center px-12 py-10" justify="center">
              <v-img
                  width="280px"
                  src="@/assets/logo.png"
                  align-self-center
                  style="position: relative; bottom: 22px"
              />
            </v-row>

            <form @submit.prevent="onSubmit" @keyup.enter="onSubmit">
              <v-text-field
                  v-model="userId"
                  label="ID"
                  clearable
                  prepend-icon="mdi-account"
                  class="font-weight-black tabindex-setting"
              />
              <v-text-field
                  v-model="userPwd"
                  :type="showPassword ? 'text' : 'password'"
                  :append-icon="showPassword ? 'mdi-eye' : 'mdi-eye-off'"
                  label="Password"
                  prepend-icon="mdi-lock"
                  class="font-weight-black tabindex-setting"
                  @click:append="showPassword = !showPassword"
                  @keyup.enter="onSubmit"
              />
            </form>
            <v-btn
                block
                x-large
                rounded
                class="mt-4 mb-1"
                color="primary font-weight-black"
                @click="onSubmit"
            >
              로그인
            </v-btn>

            <router-link to="/auth/signUp" text-decoration-none>
              <v-btn
                  block
                  x-large
                  rounded
                  color="primary lighten-4 font-weight-black"
              >
                회원가입
              </v-btn>
            </router-link>

            <div class="font-weight-black mt-4">
              아키텍쳐 프로젝트용 테스트
              <br />
              Copyright © 2022 Lee Young Hoon
              <br />
              TEL. 010-5172-2824
            </div>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import swalModule from "~/api/sweetalert/swalModule";

export default {
  name: "Login",
  data() {
     return {
       userId: "",
       userPwd: "",
       err: "",
       showPassword: ""
     }
  },
  computed: {

  },
  methods:{
    onSubmit() {
      let payload = {
        userId: this.userId,
        userPwd: this.userPwd,
        mngDbNm: "pecloud",
        pageUrl: this.$router.history.current.path
      }

      if(this.userId.length === 0 || this.userId === ''){
        swalModule.nonClkAlert({
          icon: "error",
          title: "로그인 실패",
          text: "유저 아이디를 입력해주세요."
        });

        return false;
      }

      if(this.userPwd.length === 0 || this.userPwd === ''){
        swalModule.nonClkAlert({
          icon: "error",
          title: "로그인 실패",
          text: "비밀번호를 입력해주세요."
        });

        return false;
      }

      this.$store.dispatch('login/auth', payload).then(res => {
        console.log(res);
      });

    }
  },
  mounted(){
  }
}
</script>

<style scoped>

</style>