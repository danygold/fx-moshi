# Contributing instructions

- [Contributing instructions](#contributing-instructions)
- [Architecture](#architecture)
  - [Environment](#environment)
  - [Repository structure](#repository-structure)
  - [Code style](#code-style)
  - [Documentation](#documentation)
  - [Testing](#testing)
  - [Feature and fixes](#feature-and-fixes)
- [Commits](#commits)
- [How to contribute](#how-to-contribute)
  - [Issues](#issues)
    - [Creating a new issue](#creating-a-new-issue)
  - [Pull requests](#pull-requests)
- [Labels](#labels)

Thank you for considering making a contribution to this repository. In this file, you will find guidelines for
contributing efficiently. If you are unsure whether this is the appropriate repository for a particular issue, please
review the repository structure of this organisation.

Please do not file an issue to ask a question. You will get faster results by using the resources below.

# Architecture

This section describes the project's architecture. Please read it thoroughly before contributing to the project.

## Environment

The project is written using [Java](https://www.java.com/) (Minimum version 11). Both the build process and the
dependency management are handled by [Gradle](https://gradle.org/).

## Repository structure

    .
    ├── .github                 # GitLab default configuration
    ├── src                     # Source files
    ├── ...
    └── build.gradle

### Source files

Source files are stored in `src` folder with the following structure:

    .
    ├── ...
    ├── src                    
    │   ├── main
    │   │   └── java            # Java sources
    │   └── test                # Unit tests
    │       └── java            
    └── ...

## Code style

+ Respect the original code style:
  + Only use tabs for indentation.
  + Use _well-defined_ variable names and in general
    follow [JavaSE naming conventions](https://www.oracle.com/java/technologies/javase/codeconventions-namingconventions.html)
  + Create minimal diffs - disable _On Save_ actions like _Reformat Source Code_ or _Organize Imports_. If you feel the
    source code should be reformatted create a separate PR for this change first.
  + Check for unnecessary whitespace with `git diff` -- check before committing.
  + Run `gradle checkstyleMain` and `gradle checkstyleTest` -- check before committing.

## Documentation

+ Write and update documentation details (_javadoc_) while and after contributing to the project.
  + Use standard _javadoc_ tags and avoid errors nor warnings during the _javadoc_ execution
  + Do not abuse `@inheritDoc` on overridden methods documentation.
    If you are overriding then you should use `@inheritDoc` (assuming you want to add to the original docs)
    **_but_** if you just want to duplicate the original docs, then you don't need anything.
  + ```<p>``` tags are allowed to add line breaks.
+ Chosen documentation language is ENGLISH (EN), please stick to that.
+ Always check for `gradle javadoc` before committing.

## Testing

When contributing with a pull request, please make sure that the existing test passes and that relevant tests are added
for the changes you are introducing. Please run and implement test for your implementation/fix, before
committing: `gradle test`

## Feature and fixes

When contributors wish to implement a new feature or a fix, they should branch from the development branch and open a
pull request. Branches should have a meaningful name that adheres to the following convention:

```
<type>/name_of_feature_or_fix.
```

The _type_ prefix should be one of the following:

- **feat**. Used in the case that the branch implements a new feature.
- **fix**. Used in the case that the branch implements a fix.

Valid branch names are:

- _feat/export_
- _fix/paddings_

Invalid branch names are:

- _fix_paddings_

# Commits

Please follow the [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0-beta.2/) naming convention for
consistency and to avoid problems with our continuous integration systems. The automatic systems also perform checks and
mark as not ready for review any pull request that it determines has not followed the convention.

# How to contribute

When you encounter a bug, or an issue with the system represented in this repository, you may choose to let the
developers know the nature of the issue.

## Issues

Before filing a new issue, please browse the relevant section and use the search functionality to check if it has
already been filed by someone else.

- If this issue has previously been filed, please do not create a new one. Instead, add more information to the existing
  issue, or simply add the 👍 symbol to the first message. This helps the project maintainers to identify issues and
  prioritise accordingly.
- If the issue has not already been filed, please create a new one.

### Creating a new issue

When creating a new issue, there are three categories:

- Bug report
- Feature request
- General issue

Please ensure that you select the appropriate category for the issue. Each one has a unique template designed to elicit
the information required to reproduce and fix the issue

When an issue is opened, a triage label is automatically assigned

## Pull requests

After opening an issue, you may want to help the developers further. If the issue has been triaged and if the project
maintainers give the green light, you may propose a solution. Doing so is always appreciated. For this, please use the
Pull Request tool.

Before proceeding, please ensure that your proposal relates to an issue that has already been reviewed.

The first step in opening a pull request is to fork the project. Please log in to your account, then select Fork in the
repository's landing page. This allows you to work on a dedicated fork and push your changes there. Then, if you wish to
apply these changes back in the main Immuni repository, create a pull request targeting this repository. For more
detailed
information, [please read this guide](https://help.github.com/en/github/collaborating-with-issues-and-pull-requests/creating-a-pull-request-from-a-fork).

When creating a pull request, please choose a name that adheres to
the [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0-beta.2/) naming convention. It is important to
review and follow this convention before creating a pull request. This ensures that the commit history remains clean and
makes it easy to identify what each commit does.

After choosing the appropriate name, please use the following template for the body of the pull request:

```
<!--- IMPORTANT: Please review [how to contribute](../CONTRIBUTING.md) before proceeding further. -->
<!--- IMPORTANT: If this is a Work in Progress PR, please mark it as such in GitHub. -->

## Description

<!--- Describe in detail the proposed mods -->

This PR tackles:

- ...
- ...
- ...

In particular, the ...

## Checklist

<!--- Please insert an ‘x’ after you complete each step -->

- [ ] I have followed the indications in the [CONTRIBUTING](../CONTRIBUTING.md).
- [ ] The documentation related to the proposed change has been updated accordingly (plus comments in code).
- [ ] I have written new tests for my core changes, as applicable.
- [ ] I have successfully run tests with my changes locally.
- [ ] It is ready for review! :rocket:

## Fixes

<!-- Please insert the issue numbers after the # symbol -->

- Fixes #ISSUE_NUMBER
```

There is a checklist indicating the different steps to follow. After completing each step, please mark it as such by
inserting an X between the [ ]. When all the steps have been completed, the review process begins.

# Labels

Labels are used to tag issues and make them more easily discoverable. Please refer to
the [GitHub website](https://guides.github.com/features/issues/) for more information.

| Name             | Description                                                                |
|------------------|----------------------------------------------------------------------------|
| bug              | Indicates an unexpected problem or unintended behaviour                    |
| documentation    | Indicates that improvements or additions to the documentation are needed   |
| duplicate        | Indicates similar issues or pull requests                                  |
| enhancement      | Indicates new feature requests                                             |
| good first issue | Indicates a good issue for first-time contributors                         |
| help wanted      | Indicates that a project maintainer wants help on an issue or pull request |
| invalid          | Indicates that an issue or pull request is no longer relevant              |
| question         | Indicates that an issue or pull request needs more information             |
| wontfix          | Indicates that work won't continue on an issue or pull request             |
| triage           | Indicates that the issue still needs to be triaged                         |
| QA               | Label coming directly from the QA department                               |
