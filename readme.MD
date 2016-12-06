#RotateUpAnim

##An android library to put some views in an animation queue to rotate followed by growing and shrinking the view

##Usage

###Starting the animation thread(In Activity file)

```
  RotateUpAnim rotateUpAnim = new RotateUpAnim(this);
  rotateUpAnim.start();
```

###Adding views

```
  rotateUpAnim.addView(view);
```
