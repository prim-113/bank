module.exports = function (grunt) {

    var
        jsFiles = [
            "./vendor/angular/angular.js",
            "./vendor/angular-route/angular-route.js",
            "./vendor/angular-resource/angular-resource.js",
            
            "./js/app.js",
            "./js/mainController.js"

        ],
        cssFiles = [            
            "./build/css/all.css",
            "./build/css/bootstrap.css"
        ],
        lessFiles = {};

    for (var i in cssFiles) {
        lessFiles[cssFiles[i]] = cssFiles[i].replace("/build", "").replace(".css", ".less")
    }
    lessFiles["./build/css/bootstrap.css"] = "./vendor/bootstrap/less/bootstrap.less";

    grunt.initConfig({

        jsFiles: jsFiles,
        cssFiles: cssFiles,
        minjs: 'build/js/all.min.js',

        clean: ["build"],

        less: {
            production: {
                options: {
                    paths: ["css"],
                },
                files: lessFiles
            }
        },

        csso: {
            dynamic_mappings: {
                expand: true,
                cwd: './build/css/',
                src: ['*.css'],
                dest: './build/css/',
                ext: '.min.css'
            }
        },

        concat: {
            js: {
                src: jsFiles,
                dest: 'build/js/all.js'
            },
            css: {
                src: ["build/css/*.min.css"],
                dest: 'build/css/all.min.css'
            }
        },
        ngAnnotate: {
            options: {
                add: true
            },
            main: {
                files: {
                    'build/js/all.annotated.js': ['build/js/all.js']
                }
            },
        },
        uglify: {
            options: {
                mangle: false
            },
            main: {
                files: {
                    '<%= minjs %>': '<%= concat.js.dest %>'
                }
            }
        },
        index: {
            src: 'index.tmpl', // source template file
            dest: 'index.html' // destination file (usually index.html)
        }

    });

    grunt.loadNpmTasks('grunt-contrib-clean');
    grunt.loadNpmTasks('grunt-contrib-concat');
    grunt.loadNpmTasks('grunt-contrib-uglify');
    grunt.loadNpmTasks('grunt-ng-annotate');
    grunt.loadNpmTasks('grunt-csso');
    grunt.loadNpmTasks('grunt-contrib-less');
    grunt.loadTasks('tasks');


    // Development setup
    grunt.registerTask('dev', 'Development build', function () {
        // set some global flags that all tasks can access
        grunt.config('isDebug', true);
        grunt.config('isConcat', false);
        grunt.config('isMin', false);

        // run tasks
        grunt.task.run(['clean', 'less', 'index']);
    });

    // Production setup
    grunt.registerTask('prod', 'Production build', function () {
        // set some global flags that all tasks can access
        grunt.config('isDebug', false);
        grunt.config('isConcat', true);
        grunt.config('isMin', true);

        // run tasks
        grunt.task.run(['clean', 'less', 'index', 'csso', 'concat', 'ngAnnotate', 'uglify', 'index']);
    });

    // Default task
    grunt.registerTask('default', 'dev');
};