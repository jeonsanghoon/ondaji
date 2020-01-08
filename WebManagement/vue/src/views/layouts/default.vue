<template>
  <div class="LayoutDefault">
    <nav class="LayoutDefault__nav">
      <router-link to="/">Home</router-link> |
      <router-link to="/member/about">About</router-link>
    </nav>
    <main class="LayoutDefault__main">
      <slot/>
    </main>
    <footer class="LayoutDefault__footer">
      &copy; Awesome Company
    </footer>
  </div>
</template>